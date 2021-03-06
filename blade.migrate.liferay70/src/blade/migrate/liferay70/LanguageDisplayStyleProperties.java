package blade.migrate.liferay70;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import blade.migrate.api.FileMigrator;

@Component(
	property = {
		"file.extensions=properties",
		"problem.title=Language Display Style Properties",
		"problem.summary=Replaced the Language Portlet's Display Styles with ADTs",
		"problem.tickets=LPS-54419",
		"problem.url=https://github.com/liferay/liferay-portal/blob/master/readme/7.0/BREAKING_CHANGES.markdown#replaced-the-language-portlets-display-styles-with-adts",
	},
	service = FileMigrator.class
)
public class LanguageDisplayStyleProperties extends PropertiesFileMigrator {

	@Override
	protected void addPropertiesToSearch(List<String> properties) {
		properties.add("language.display.style.default");
		properties.add("language.display.style.options");
	}

}
