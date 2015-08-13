	package hello;
	
	import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

	import org.springframework.http.HttpEntity;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class FileDownloadController {
		@RequestMapping(value = "download/{fileName:.+}", method = RequestMethod.GET)
		public HttpEntity<byte[]> download(@PathVariable("fileName") String fileName) throws IOException {
			
			byte[] data;
			data = read(new File("userFiles/" + fileName));
			
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "octet-stream"));
			header.set("Content-Disposition", "attachment; filename=" + fileName.replace(" ", "_"));
			//length of the byteArray
			header.setContentLength(data.length);
			
			return new HttpEntity<byte[]>(data, header);
		}
		
	public byte[] read(File file) throws IOException {
		byte[] buffer = new byte[(int) file.length()];
		InputStream ios = null;
		try {
			ios = new FileInputStream(file);
			if (ios.read(buffer) == -1) {
				throw new IOException("EOF reached while trying to read the whole file");
			}
		} finally {
			try {
				if (ios != null)
					ios.close();
			} catch (IOException e) {
			}
		}

		return buffer;
	}
}