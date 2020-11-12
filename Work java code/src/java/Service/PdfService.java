package Service;

import POJO.BillingAddress;
import DAO.*;
import POJO.*;
import com.itextpdf.text.*;
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
import java.util.List;

public class PdfService {

    private List<BillingAddress> billingAddressList=null;
    private List<ContactDetails> contactDetails=null;
    private List<Country> countryList=null;
    private List<EuropeanAviation> europeanAviations=null;
    private List<Payment> payments=null;
    private List<PersonalInformation> personalInformations=null;

    public PdfService(){
        readDb();
    }

    private void readDb(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建Session实例
        SqlSession session = sqlSessionFactory.openSession();

        BillingAddressMapper billingAddressMapper=session.getMapper(BillingAddressMapper.class);
        billingAddressList=billingAddressMapper.getBillingAddress();

        ContactDetailsMapper contactDetailsMapper=session.getMapper(ContactDetailsMapper.class);
        contactDetails=contactDetailsMapper.getContactDetails();

        CountryMapper countryMapper=session.getMapper(CountryMapper.class);
        countryList=countryMapper.getCountry();

        EuropeanAviationMapper europeanAviationMapper=session.getMapper(EuropeanAviationMapper.class);
        europeanAviations=europeanAviationMapper.getEuropeanAviation();

        PaymentMapper paymentMapper=session.getMapper(PaymentMapper.class);
        payments=paymentMapper.getPayment();

        PersonalInformationMapper personalInformationMapper=session.getMapper(PersonalInformationMapper.class);
        personalInformations=personalInformationMapper.getPersonalInformation();

        //关闭Session
        session.close();
    }

    public void writePdfTable(String fileName) throws Exception {
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

            String title="BillingAddress";
            PdfPTable table1=new PdfPTable(6);
            table1.setTotalWidth(PageSize.A4.getWidth()-40);
            table1.setLockedWidth(true);
            PdfPHeaderCell header = new PdfPHeaderCell();
            header.addElement(new Paragraph(title, fontBigBold));
            header.setColspan(6);
            table1.addCell(header);
            table1.addCell(new Paragraph("fullname",font));
            table1.addCell(new Paragraph("email",font));
            table1.addCell(new Paragraph("address",font));
            table1.addCell(new Paragraph("city",font));
            table1.addCell(new Paragraph("state",font));
            table1.addCell(new Paragraph("zip",font));
            for(BillingAddress billingAddress : billingAddressList){
                table1.addCell(new Paragraph(billingAddress.getFullname(),font));
                table1.addCell(new Paragraph(billingAddress.getEmail(),font));
                table1.addCell(new Paragraph(billingAddress.getAddress(),font));
                table1.addCell(new Paragraph(billingAddress.getCity(),font));
                table1.addCell(new Paragraph(billingAddress.getState(),font));
                table1.addCell(new Paragraph(billingAddress.getZip(),font));
            }

            String title2="ContactDetails";
            PdfPTable table2=new PdfPTable(4);
            table2.setTotalWidth(PageSize.A4.getWidth()-40);
            table2.setLockedWidth(true);
            PdfPHeaderCell header2 = new PdfPHeaderCell();
            header2.addElement(new Paragraph(title2, fontBigBold));
            header2.setColspan(4);
            table2.addCell(header2);
            table2.addCell(new Paragraph("countrycode",font));
            table2.addCell(new Paragraph("telephone",font));
            table2.addCell(new Paragraph("emailaddress",font));
            table2.addCell(new Paragraph("iswantcustommadeemail",font));
            for(ContactDetails details : contactDetails){
                table2.addCell(new Paragraph(details.getCountrycode(),font));
                table2.addCell(new Paragraph(""+details.getTelephone(),font));
                table2.addCell(new Paragraph(details.getEmailaddress(),font));
                table2.addCell(new Paragraph(String.valueOf(details.getIswantcustommadeemail()),font));
            }

            String title3="Payment";
            PdfPTable table3=new PdfPTable(5);
            table3.setTotalWidth(PageSize.A4.getWidth()-40);
            table3.setLockedWidth(true);
            PdfPHeaderCell header3 = new PdfPHeaderCell();
            header3.addElement(new Paragraph(title3, fontBigBold));
            header3.setColspan(5);
            table3.addCell(header3);
            table3.addCell(new Paragraph("nameoncard",font));
            table3.addCell(new Paragraph("creditcardnumber",font));
            table3.addCell(new Paragraph("expmonth",font));
            table3.addCell(new Paragraph("expyear",font));
            table3.addCell(new Paragraph("cvv",font));
            for(Payment payment : payments){
                table3.addCell(new Paragraph(payment.getNameoncard(),font));
                table3.addCell(new Paragraph(payment.getCreditcardnumber(),font));
                table3.addCell(new Paragraph(payment.getExpmonth(),font));
                table3.addCell(new Paragraph(""+payment.getExpyear(),font));
                table3.addCell(new Paragraph(""+payment.getCvv(),font));
            }

            String title4="ContactDetails";
            PdfPTable table4=new PdfPTable(1);
            table4.setTotalWidth(PageSize.A4.getWidth()-40);
            table4.setLockedWidth(true);
            PdfPHeaderCell header4 = new PdfPHeaderCell();
            header4.addElement(new Paragraph(title4, fontBigBold));
            header4.setColspan(1);
            table4.addCell(header4);
            table4.addCell(new Paragraph("country",font));
            for(Country country : countryList){
                table4.addCell(new Paragraph(country.getCountry(),font));
            }

            String title5="Payment";
            PdfPTable table5=new PdfPTable(5);
            table5.setTotalWidth(PageSize.A4.getWidth()-40);
            table5.setLockedWidth(true);
            PdfPHeaderCell header5 = new PdfPHeaderCell();
            header5.addElement(new Paragraph(title5, fontBigBold));
            header5.setColspan(5);
            table5.addCell(header5);
            table5.addCell(new Paragraph("title",font));
            table5.addCell(new Paragraph("firstname",font));
            table5.addCell(new Paragraph("lastname",font));
            table5.addCell(new Paragraph("iscard",font));
            table5.addCell(new Paragraph("cardnumber",font));
            for(PersonalInformation information : personalInformations){
                table5.addCell(new Paragraph(information.getTitle(),font));
                table5.addCell(new Paragraph(information.getFirstname(),font));
                table5.addCell(new Paragraph(information.getLastname(),font));
                table5.addCell(new Paragraph(""+information.getIscard(),font));
                table5.addCell(new Paragraph(""+information.getCardnumber(),font));
            }

            String title6="EuropeanAviation";
            PdfPTable table6=new PdfPTable(7);
            table6.setTotalWidth(PageSize.A4.getWidth()-40);
            table6.setLockedWidth(true);
            PdfPHeaderCell header6 = new PdfPHeaderCell();
            header6.addElement(new Paragraph(title6, fontBigBold));
            header6.setColspan(7);
            table6.addCell(header6);
            table6.addCell(new Paragraph("id",font));
            table6.addCell(new Paragraph("startcountry",font));
            table6.addCell(new Paragraph("endcountry",font));
            table6.addCell(new Paragraph("toorreturn",font));
            table6.addCell(new Paragraph("dateofdeparture",font));
            table6.addCell(new Paragraph("returndate",font));
            table6.addCell(new Paragraph("tanktype",font));
            for(EuropeanAviation europeanAviation : europeanAviations){
                table6.addCell(new Paragraph(""+europeanAviation.getId(),font));
                table6.addCell(new Paragraph(europeanAviation.getStartcountry(),font));
                table6.addCell(new Paragraph(europeanAviation.getEndcountry(),font));
                table6.addCell(new Paragraph(""+europeanAviation.getToorreturn(),font));
                table6.addCell(new Paragraph(""+europeanAviation.getDateofdeparture(),font));
                table6.addCell(new Paragraph(""+europeanAviation.getReturndate(),font));
                table6.addCell(new Paragraph(europeanAviation.getTanktype(),font));
            }

            document.add(table1);
            document.add(table2);
            document.add(table3);
            document.add(table4);
            document.add(table5);
            document.add(table6);

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
