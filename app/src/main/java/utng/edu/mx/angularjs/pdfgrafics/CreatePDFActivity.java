package utng.edu.mx.angularjs.pdfgrafics;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import utng.edu.mx.angularjs.DatabaseHelper;
import utng.edu.mx.angularjs.R;

public class CreatePDFActivity extends Activity implements View.OnClickListener{
    private final static String NOMBRE_DIRECTORIO = "Certificado";
    private final static String NOMBRE_DOCUMENTO = "Certificado.pdf";
    private final static String ETIQUETA_ERROR = "ERROR";
    private Button btnCreatePDF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_activity);

        btnCreatePDF=(Button)findViewById(R.id.btnGenerar);
        btnCreatePDF.setOnClickListener(this);
        }
    //transicion ventanas
    //overridePendingTransition(R.anim.left_in, R.anim.left_out);
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGenerar:
                // Creamos el documento.
                Document documento = new Document();

                try {

                    // Creamos el fichero con el nombre que deseemos.
                    File f = crearFichero(NOMBRE_DOCUMENTO);

                    // Creamos el flujo de datos de salida para el fichero donde
                    // guardaremos el pdf.
                    FileOutputStream ficheroPdf = new FileOutputStream(
                            f.getAbsolutePath());

                    // Asociamos el flujo que acabamos de crear al documento.
                    PdfWriter writer = PdfWriter.getInstance(documento, ficheroPdf);

                    // Incluimos el píe de página y una cabecera
                    HeaderFooter cabecera = new HeaderFooter(new Phrase("Universidad Tecnológica del Norte de Guanajuato"), false);
                    HeaderFooter pie = new HeaderFooter(new Phrase("UTNG"), false);

                    documento.setHeader(cabecera);
                    documento.setFooter(pie);

                    // Abrimos el documento.
                    documento.open();
                    Bitmap bitmaplog = BitmapFactory.decodeResource(this.getResources(), R.drawable.logoutng);
                    ByteArrayOutputStream streamlog = new ByteArrayOutputStream();
                    bitmaplog.compress(Bitmap.CompressFormat.JPEG, 50, streamlog);
                    Image imagenlog = Image.getInstance(streamlog.toByteArray());
                    documento.add(imagenlog);

                    Font font = FontFactory.getFont(FontFactory.HELVETICA, 28, Font.BOLD);
                    documento.add(new Paragraph("Certificación JPA (Java Persisten API)"));
                    documento.add(new Paragraph("El grupo GSI-1151 otorga el presente Reconocimiento a:"));
                    DatabaseHelper helper= new DatabaseHelper(this);
                    String name = helper.traerNombre();
                    documento.add(new Paragraph(name, font));
                    documento.add(new Paragraph("Por haber concluido con exito los cuestionarios presentados en esta aplicacion"));
                    // Insertamos una imagen que se encuentra en los recursos de la
                    // aplicación.
                    Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.utng);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    Image imagen = Image.getInstance(stream.toByteArray());
                    documento.add(imagen);

                    documento.add(new Paragraph("Trabajando en pro de la educacion de los Jovenes", font));
                    documento.addCreationDate();
                } catch (DocumentException e) {
                    Log.e(ETIQUETA_ERROR, e.getMessage());
                } catch (IOException e) {
                    Log.e(ETIQUETA_ERROR, e.getMessage());
                } finally {

                    // Cerramos el documento.
                    Toast.makeText(this, "Tu certificado a sido guardado en Dowload/Cetificado", Toast.LENGTH_SHORT).show();
                    documento.close();
                }
                break;
            default:
                break;
        }
    }
    public static File crearFichero(String nombreFichero) throws IOException {
        File ruta = getRuta();
        File fichero = null;
        if (ruta != null)
            fichero = new File(ruta, nombreFichero);
        return fichero;
    }

    /**
     * Obtenemos la ruta donde vamos a almacenar el fichero.
     *
     * @return
     */
    public static File getRuta() {

        // El fichero será almacenado en un directorio dentro del directorio
        // Descargas
        File ruta = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            ruta = new File(
                    Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    NOMBRE_DIRECTORIO);

            if (ruta != null) {
                if (!ruta.mkdirs()) {
                    if (!ruta.exists()) {
                        return null;
                    }
                }
            }
        } else {
        }

        return ruta;
    }
}

