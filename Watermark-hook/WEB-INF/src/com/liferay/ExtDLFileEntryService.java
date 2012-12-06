package com.liferay;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceWrapper;
import com.liferay.portlet.documentlibrary.service.DLFileEntryService;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

public class ExtDLFileEntryService extends DLFileEntryServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portlet.documentlibrary.service.DLFileEntryServiceWrapper#DLFileEntryServiceWrapper(DLFileEntryService dlFileEntryService)
	 */
	
	@Override
	public DLFileEntry addFileEntry(long groupId, long repositoryId,
			long folderId, String sourceFileName, String mimeType,
			String title, String description, String changeLog,
			long fileEntryTypeId, Map<String, Fields> fieldsMap, File file,
			InputStream is, long size, ServiceContext serviceContext)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		System.out.println("Hello service just service");
		
		return super.addFileEntry(groupId, repositoryId, folderId, sourceFileName,
				mimeType, title, description, changeLog, fileEntryTypeId, fieldsMap,
				file, is, size, serviceContext);
	}
	public ExtDLFileEntryService(DLFileEntryService dlFileEntryService) {
		super(dlFileEntryService);
	}

}