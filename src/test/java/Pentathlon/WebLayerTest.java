package Pentathlon;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import Pentathlon.data.AthleteRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(PentathlonController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AthleteRepository repository;
    
    @Test
    public void shouldReturnOK() throws Exception {

        this.mockMvc.perform(get("/athletes")).andDo(print()).andExpect(status().isOk());
    }
}
