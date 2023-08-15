//package ru.kubzay.restgatewayapi.rest;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.LinkedList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.kubzay.restgatewayapi.services.word.WordService;
//import ru.kubzay.restgatewayapi.storage.syllable.ParsedWordResult;
//
//https://spring.io/guides/gs/testing-web/
//https://www.baeldung.com/spring-boot-testing
//
//@SpringBootTest
//@WebMvcTest(WordController.class)
//class WordControllerParseTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @TestConfiguration
//    static class WordServiceTestContextConfiguration {
//        @Bean
//        public WordService wordService() {
//            return new WordService();
//        }
//    }
//
//    @MockBean
//    private WordService service; ?
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//
//    @Test
//    public void ggg() throws Exception {
//        ParsedWordResult pwr = new ParsedWordResult();
//        LinkedList<ParsedWordResult> list = new LinkedList<>();
//        list.add(pwr);
////        when(service.parseOneWord("РУ")).thenReturn(list);
//        this.mockMvc.perform(get("/api/v1/auth/word")).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello, Mock")));
//    }
//}
