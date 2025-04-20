package com.pranjal.GarageBillingSystem;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;


import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class InvoicePdfGenerator {

    public static byte[] generateInvoicePdf(Invoice invoice) throws DocumentException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font labelFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

        Paragraph title = new Paragraph("CHETAN AUTOMOBILE", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        Paragraph address = new Paragraph("RING ROAD POWERHOUSE SQUARE BESIDE RAJLAXMI HALL NAGPUR\nMob.: 9423515180", normalFont);
        address.setAlignment(Element.ALIGN_CENTER);
        address.setSpacingAfter(10);
        document.add(address);

        PdfPTable infoTable = new PdfPTable(2);
        infoTable.setWidthPercentage(100);
        infoTable.setWidths(new float[]{1, 2});

        infoTable.addCell(getCell("V No.:", labelFont));
        infoTable.addCell(getCell(String.valueOf(invoice.getId()), normalFont));
        infoTable.addCell(getCell("Date:", labelFont));
        infoTable.addCell(getCell(invoice.getBillDate().toString(), normalFont));
        infoTable.addCell(getCell("M/s:", labelFont));
        infoTable.addCell(getCell(invoice.getCustomerName(), normalFont));
        infoTable.setSpacingAfter(20);

        document.add(infoTable);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{1, 5, 2, 2});

        table.addCell(getHeaderCell("Sr. No."));
        table.addCell(getHeaderCell("Estimate"));
        table.addCell(getHeaderCell("Qnt."));
        table.addCell(getHeaderCell("Rate"));

        List<BillItem> items = invoice.getBillItems();
        for (int i = 0; i < items.size(); i++) {
            BillItem item = items.get(i);
            table.addCell(getCell(String.valueOf(i + 1), normalFont));
            table.addCell(getCell(item.getDescription(), normalFont));
            table.addCell(getCell(String.valueOf(item.getQuantity()), normalFont));
            table.addCell(getCell("₹" + item.getPrice(), normalFont));
        }

        int emptyRows = 10 - items.size();
        for (int i = 0; i < emptyRows; i++) {
            table.addCell(getCell(" ", normalFont));
            table.addCell(getCell(" ", normalFont));
            table.addCell(getCell(" ", normalFont));
            table.addCell(getCell(" ", normalFont));
        }

        document.add(table);

        Paragraph total = new Paragraph("Total Amount: ₹" + invoice.getTotalCost(), labelFont);
        total.setAlignment(Element.ALIGN_RIGHT);
        total.setSpacingBefore(10);
        document.add(total);

        // Footer
        Paragraph thanks = new Paragraph("Thanks!", normalFont);
        thanks.setAlignment(Element.ALIGN_LEFT);
        thanks.setSpacingBefore(20);
        document.add(thanks);

        Paragraph sign = new Paragraph("For CHETAN AUTOMOBILE", labelFont);
        sign.setAlignment(Element.ALIGN_RIGHT);
        document.add(sign);

        document.close();
        return out.toByteArray();
    }

    private static PdfPCell getHeaderCell(String text) {
        Font font = new Font(Font.HELVETICA, 12, Font.BOLD, Color.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }

    private static PdfPCell getCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cell;
    }
}
