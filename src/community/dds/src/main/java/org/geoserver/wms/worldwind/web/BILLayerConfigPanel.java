package org.geoserver.wms.worldwind.web;

import java.util.Arrays;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;
import org.geoserver.web.publish.LayerConfigurationPanel;
import org.geoserver.web.util.MapModel;

/**
 * Configures a layer KML related attributes (coming from metadata)
 */
@SuppressWarnings("serial")
public class BILLayerConfigPanel extends LayerConfigurationPanel
{
    @SuppressWarnings("unchecked")
    public BILLayerConfigPanel(String id, IModel<org.geoserver.catalog.LayerInfo> model)
    {
        super(id, model);

        PropertyModel metadata = new PropertyModel(model, "resource.metadata");
        add(new DropDownChoice("bil.defaultDataTypeAttribute",
                new MapModel(metadata, "bil.defaultDataTypeAttribute"),
                new ListModel<>(Arrays.asList("Same as source data", "application/bil8", "application/bil16", "application/bil32"))));

        add(new DropDownChoice("bil.byteOrderAttribute",
                new MapModel(metadata, "bil.byteOrderAttribute"),
                new ListModel<>(Arrays.asList("Big Endian", "Little Endian"))));

        add(new TextField("bil.noDataOutputAttribute",
                new MapModel(metadata, "bil.noDataOutputAttribute"), Double.class));
    }
}
