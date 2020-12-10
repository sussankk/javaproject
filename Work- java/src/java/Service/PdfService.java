package Service;

import DAO.*;
import POJO.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PdfService {

    private List<Contactdetails> contactdetailsList = null;
    private List<Flight> flightList = null;
    private List<Flightinformation> flightinformationList = null;
    private List<Payment> paymentList = null;
    private List<Personalinformation> personalinformationList = null;
    private List<User> userList = null;

    public PdfService() {
        readDb();
    }

    private void readDb() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Initialize mybatis and create an instance of the SqlSessionFactory class
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //Create Session instance
        SqlSession session = sqlSessionFactory.openSession();

        ContactdetailsMapper contactdetailsMapper = session.getMapper(ContactdetailsMapper.class);
        contactdetailsList = contactdetailsMapper.getContactdetails();

        FlightMapper flightMapper = session.getMapper(FlightMapper.class);
        flightList = flightMapper.getFlight();

        FlightinformationMapper flightinformationMapper = session.getMapper(FlightinformationMapper.class);
        flightinformationList = flightinformationMapper.getFlightinformation();

        PaymentMapper paymentMapper = session.getMapper(PaymentMapper.class);
        paymentList = paymentMapper.getPayment();

        PersonalinformationMapper personalinformationMapper = session.getMapper(PersonalinformationMapper.class);
        personalinformationList = personalinformationMapper.getPersonalinformation();

        UserMapper userMapper = session.getMapper(UserMapper.class);
        userList = userMapper.getUser();

        //close Session
        session.close();
    }

    public void writePdfTable(String fileName) throws Exception {
        List<Flightinformation> flightinformationTemp = new ArrayList<>();
        List<Flight> flightTemp = new ArrayList<>();
        List<Contactdetails> contactdetailsTemp = new ArrayList<>();
        List<Payment> paymentTemp = new ArrayList<>();

        for (User user : userList) {
            for (Personalinformation personalinformation : personalinformationList) {
                if (user.getEmail().equals(personalinformation.getEmail())) {
                    for (Flightinformation flightinformation : flightinformationList) {
                        if (personalinformation.getPassportnum().equals(flightinformation.getPassportnum())) {
                            for (Flight flight : flightList) {
                                if (flight.getFlightnum().equals(flightinformation.getFlightnum())) {
                                    flightinformationTemp.add(flightinformation);
                                    flightTemp.add(flight);
                                }
                            }
                        }
                    }
                    for (Contactdetails contactdetails : contactdetailsList) {
                        if (personalinformation.getTelephone().equals(contactdetails.getTelephone())) {
                            for (Payment payment : paymentList) {
                                if (payment.getEmail().equals(contactdetails.getEmail())) {
                                    paymentTemp.add(payment);
                                    contactdetailsTemp.add(contactdetails);
                                }
                            }
                        }
                    }
                }
            }
        }

        Document document = null;
        PdfWriter writer = null;
        try {
            String fullPath = fileName + ".pdf";
            document = new Document();
            document.setPageSize(PageSize.A4);
            writer = PdfWriter.getInstance(document, new FileOutputStream(fullPath));
            document.open();

            // Chinese fonts, solve the problem that Chinese cannot be displayed
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            // Normal font
            Font font = new Font(bfChinese);
            // Normal bold font
            Font fontBold = new Font(bfChinese, 12, Font.BOLD);
            // Bold font
            Font fontBigBold = new Font(bfChinese, 20, Font.BOLD);

            String title = "UserInformation";
            PdfPTable table1 = new PdfPTable(10);
            table1.setTotalWidth(PageSize.A4.getWidth() - 40);
            table1.setLockedWidth(true);
            PdfPHeaderCell header = new PdfPHeaderCell();
            header.addElement(new Paragraph(title, fontBigBold));
            header.setColspan(10);
            table1.addCell(header);
            table1.addCell(new Paragraph("fullname", font));
            table1.addCell(new Paragraph("email", font));
            table1.addCell(new Paragraph("address", font));
            table1.addCell(new Paragraph("city", font));
            table1.addCell(new Paragraph("zip", font));
            table1.addCell(new Paragraph("nameoncard", font));
            table1.addCell(new Paragraph("creditCardNum", font));
            table1.addCell(new Paragraph("expYear", font));
            table1.addCell(new Paragraph("telephone", font));
            table1.addCell(new Paragraph("country", font));

            for (int i = 0; i < paymentTemp.size(); i++) {
                Payment temp = paymentTemp.get(i);
                Contactdetails ctemp = contactdetailsTemp.get(i);
                table1.addCell(new Paragraph(temp.getFullName(), font));
                table1.addCell(new Paragraph(temp.getEmail(), font));
                table1.addCell(new Paragraph(temp.getAddress(), font));
                table1.addCell(new Paragraph(temp.getCity(), font));
                table1.addCell(new Paragraph(temp.getZip(), font));
                table1.addCell(new Paragraph(temp.getNameoncard(), font));
                table1.addCell(new Paragraph(temp.getCreditcardnum(), font));
                table1.addCell(new Paragraph("" + temp.getExpyear(), font));
                table1.addCell(new Paragraph(ctemp.getTelephone(), font));
                table1.addCell(new Paragraph(ctemp.getCountry(), font));
            }


            String title2 = "FlightInformation";
            PdfPTable table2 = new PdfPTable(6);
            table2.setTotalWidth(PageSize.A4.getWidth() - 40);
            table2.setLockedWidth(true);
            PdfPHeaderCell header2 = new PdfPHeaderCell();
            header2.addElement(new Paragraph(title2, fontBigBold));
            header2.setColspan(6);
            table2.addCell(header2);
            table2.addCell(new Paragraph("flightNum", font));
            table2.addCell(new Paragraph("departuredate", font));
            table2.addCell(new Paragraph("passportnum", font));
            table2.addCell(new Paragraph("flightcode", font));
            table2.addCell(new Paragraph("flightnum", font));
            table2.addCell(new Paragraph("price", font));

            for (int i = 0; i < flightinformationTemp.size(); i++) {
                Flightinformation temp = flightinformationTemp.get(i);
                Flight ftemp = flightTemp.get(i);
                table2.addCell(new Paragraph(temp.getFlightnum(), font));
                table2.addCell(new Paragraph(temp.getDeparturedate().toString(), font));
                table2.addCell(new Paragraph(temp.getPassportnum(), font));
                table2.addCell(new Paragraph("" + ftemp.getFlightcode(), font));
                table2.addCell(new Paragraph(ftemp.getFlightnum(), font));
                table2.addCell(new Paragraph(ftemp.getPrice(), font));
            }

            document.add(table1);
            document.add(table2);

            // Close the document to output
            document.close();
            writer.close();
        } catch (Exception e) {
            throw e;
        } finally {
            if (document != null) {
                document.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

}
