package blade.migrate.liferay70;

import java.io.File;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import blade.migrate.api.FileMigrator;
import blade.migrate.core.JavaFileChecker;
import blade.migrate.core.JavaFileMigrator;
import blade.migrate.core.SearchResult;

@Component(
		property = {
			"file.extension=java",
			"problem.title=RepositoryLocalServiceUtil changes",
			"problem.url=https://github.com/liferay/liferay-portal/blob/master/readme/7.0/BREAKING_CHANGES.markdown#removed-methods-getgrouplocalrepositoryimpl-and-getlocalrepositoryimpl-from-repositorylocalservice-and-repositoryservice",
			"problem.summary=Removed Methods getGroupLocalRepositoryImpl and getLocalRepositoryImpl from RepositoryLocalService and RepositoryService",
			"problem.type=java",
			"problem.tickets=LPS-55566",
		},
		service = FileMigrator.class
)
public class RepositoryServiceUtilGetRepositoryImplInvocation extends JavaFileMigrator {

	@Override
	protected List<SearchResult> searchJavaFile(File file) {
		final JavaFileChecker javaFileChecker = new JavaFileChecker(file);

		return javaFileChecker.findMethodInvocations(null, "RepositoryLocalServiceUtil", "getRepositoryImpl");
	}

}
