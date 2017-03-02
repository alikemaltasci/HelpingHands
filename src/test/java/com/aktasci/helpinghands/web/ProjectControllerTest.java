package com.aktasci.helpinghands.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.aktasci.helpinghands.HelpingHandsApplication;
import com.aktasci.helpinghands.domain.NeededSupport;
import com.aktasci.helpinghands.domain.Project;
import com.aktasci.helpinghands.domain.ProjectRepository;
import com.aktasci.helpinghands.domain.User;
import com.aktasci.helpinghands.domain.UserRepository;
import com.google.gson.Gson;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelpingHandsApplication.class)
@WebAppConfiguration
public class ProjectControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

		Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		this.userRepository.deleteAll();
		User user1 = new User("Ali Kemal", "Taşcı", "ali_kemal_tasci@yahoo.com", "123", "+905448532352");
		this.userRepository.save(user1);

		Project project = new Project();
		project.setUserId(user1.getId());
		project.setName("Refugee Support");
		project.setDescription("Refugee Support desc");
		project.setNeededSupports(new ArrayList<NeededSupport>());

		this.projectRepository.save(project);
	}

	@Test
	public void getExisting() throws Exception {
		mockMvc.perform(get("/project/")).andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$[0].name", is("Refugee Support")));
	}

	@Test
	@Ignore
	public void addNotExisting() throws Exception {
		Project project = new Project();
		project.setUserId(1L);
		project.setName("Refugee Support2");
		project.setDescription("Refugee Support desc");
		project.setNeededSupports(new ArrayList<NeededSupport>());

		Gson gson = new Gson();
		String json = gson.toJson(project);

		mockMvc.perform(post("/project/").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());

	}

}
