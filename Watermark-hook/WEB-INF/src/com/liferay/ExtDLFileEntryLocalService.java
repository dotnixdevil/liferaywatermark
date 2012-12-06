package com.liferay;
//Programmed By:Tammam Awad
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import java.awt.image.RenderedImage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import javax.imageio.ImageIO;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceWrapper;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalService;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
public class ExtDLFileEntryLocalService extends DLFileEntryLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceWrapper#DLFileEntryLocalServiceWrapper(DLFileEntryLocalService dlFileEntryLocalService)
	 */
	
	
	@Override
	public DLFileEntry addFileEntry(long userId, long groupId,
			long repositoryId, long folderId, String sourceFileName,
			String mimeType, String title, String description,
			String changeLog, long fileEntryTypeId,
			Map<String, Fields> fieldsMap, File file, InputStream is,
			long size, ServiceContext serviceContext) throws PortalException,
			SystemException {

		InputStream iss=null;
		
		
		try{
		if(DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(fileEntryTypeId).getName().equals("Image")){
		BufferedImage bi= ImageIO.read(is);
		Image i=bi;
		Graphics g=i.getGraphics();
		g.setFont(new Font("Arial", Font.BOLD, 100));
		g.setColor(Color.RED);
		
		g.drawString("SANA",0,100);
		g.dispose();
		System.out.println(mimeType);	
	    ByteArrayOutputStream baos=new ByteArrayOutputStream();
		
		ImageIO.write((RenderedImage)i,mimeType.replace("image/",""),baos );
		iss=new ByteArrayInputStream(baos.toByteArray());
		
	
	
	/*	byte b[]=new byte[is.available()];
		IIOByteBuffer iob=new IIOByteBuffer(b,0, is.available());
			iss.readBytes(iob,is.available());
			ImageIcon ic=new ImageIcon();
			*/
/*	   File f=File.createTempFile("sdsd",".txt");
	   
	   ImageIO.write((RenderedImage)i,mimeType, f);
	   
	   fis=new FileInputStream(f);
	  
	*/   

		
		
		}}catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		System.out.println("id"+fileEntryTypeId);
		// TODO Auto-generated method stub
		
		return super.addFileEntry(userId, groupId, repositoryId, folderId,
				sourceFileName, mimeType, title, description, changeLog,
				fileEntryTypeId, fieldsMap, file, iss, size, serviceContext);
	}
	@Override
	public DLFileEntry addDLFileEntry(DLFileEntry dlFileEntry)
			throws SystemException {
		System.out.println("Hello Hook");
		
		// TODO Auto-generated method stub
		return super.addDLFileEntry(dlFileEntry);
	}
	
	public ExtDLFileEntryLocalService(DLFileEntryLocalService dlFileEntryLocalService) {
		super(dlFileEntryLocalService);
	}

}