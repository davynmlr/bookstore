package fi.haagahelia.bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BookRestControllerTest {

    @Autowired 
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void testGetAllBooks() throws Exception {
        this.mockMvc.perform(get("/books"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Animal Farm")));
    }
    
    @Test
    @WithMockUser
    public void testGetBookById() throws Exception {
    this.mockMvc.perform(get("/books/1"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Animal Farm")));
    }
}
