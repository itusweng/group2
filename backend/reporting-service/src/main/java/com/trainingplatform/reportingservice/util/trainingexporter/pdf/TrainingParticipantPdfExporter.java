package com.trainingplatform.reportingservice.util.trainingexporter.pdf;


import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.trainingplatform.reportingservice.model.training.response.TrainingParticipantResponseDTO;
import com.trainingplatform.reportingservice.model.training.response.TrainingResponseDTO;
import com.trainingplatform.reportingservice.util.trainingexporter.ITrainingExporter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TrainingParticipantPdfExporter extends ITrainingExporter {

    private List<TrainingParticipantResponseDTO> participants;
    private TrainingResponseDTO training;

    @Override
    public void exportTrainingParticipants(HttpServletResponse response, List<TrainingParticipantResponseDTO> participants, TrainingResponseDTO training) throws IOException {
        this.participants = participants;
        this.training = training;

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);

        Paragraph p = new Paragraph(String.format("Participant list of %s", training.getTitle()), font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(4);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Surname", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Job Title", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        participants.forEach(participant -> {
            table.addCell(participant.getId().toString());
            table.addCell(participant.getFirst_name());
            table.addCell(participant.getLast_name());
            table.addCell(participant.getJob_title());
        });
    }
}

