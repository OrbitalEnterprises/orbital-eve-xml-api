package enterprises.orbital.impl.evexmlapi.chr;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

/**
 * Factory which returns generic row data collector based on type.
 */
public class CharacterSheetRowsetFactory extends AbstractObjectCreationFactory {
	@Override
	public Object createObject(Attributes attr) {
		String type = attr.getValue("name");
		return new CharacterSheetRowsetDataCollector(type);
	}
}
