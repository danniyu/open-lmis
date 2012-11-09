package org.openlmis.admin.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.ResultActions;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;


@ContextConfiguration(locations = "classpath*:/applicationContext-admin-web.xml")

@RunWith(SpringJUnit4ClassRunner.class)
public class RnRTemplateControllerIT {

    @Autowired
    RnRTemplateController controller;

    @Test
    public void shouldGetAllMasterRnRColumns() throws Exception {
        int existingProgramId = 1;
        ResultActions resultActions = standaloneSetup(controller).setViewResolvers(contentNegotiatingViewResolver()).build()
                .perform(get("/admin/rnr/" + existingProgramId + "/columns.json"));
        String contentAsString = resultActions.andReturn().getResponse().getContentAsString();
        String msdProductColumn = "\"name\":\"MSD ProductCode\",\"description\":\"This is Unique identifier for each commodity\",\"position\":1,\"label\":\"MSD ProductCode\",\"defaultValue\":\"\",\"dataSource\":\"Reference Value (Product Table)\",\"formula\":\"\",\"indicator\":\"O\",\"used\":true,\"visible\":true,\"mandatory\":true";
        assertThat(contentAsString.contains(msdProductColumn), is(true));
    }

    private ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setMediaTypes(new HashMap<String, String>() {{
            put("json", "application/json");
        }});
        viewResolver.setDefaultViews(new ArrayList<View>() {{
            add(new MappingJacksonJsonView());
        }});
        return viewResolver;
    }
}
