package blade.migrate.liferay70;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import blade.migrate.api.FileMigrator;

@Component(
	property = {
		"file.extensions=properties",
		"problem.title=Asset Publisher Proerties Removed",
		"problem.summary=Removed the asset.publisher.asset.entry.query.processors Property",
		"problem.tickets=LPS-52966",
		"problem.url=https://github.com/liferay/liferay-portal/blob/master/readme/7.0/BREAKING_CHANGES.markdown#removed-the-assetpublisherassetentryqueryprocessors-property",
	},
	service = FileMigrator.class
)
public class AssetPublisherProperties extends PropertiesFileMigrator {

	@Override
	protected void addPropertiesToSearch(List<String> _properties) {
		_properties.add("asset.publisher.asset.entry.query.processors");
	}

}
