package ru.otus.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.exception.FileNotPresentException;
import ru.otus.exception.ParsingException;
import ru.otus.service.I18nService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CsvQuestionDaoTest {
    private static final int QUESTIONS_COUNT = 5;

    private static final String VALID_FILE = "/questions.csv";

    private static final String NON_EXISTS_FILE = "/no-such-file.csv";

    private static final String WRONG_FORMAT_FILE = "/wrong-format.csv";

    @Mock
    I18nService i18nService;

    @InjectMocks
    CsvQuestionDao questionDao;

    @Test
    public void validFileTest() {
        when(i18nService.getMessageByCode("file.name")).thenReturn(VALID_FILE);
        var loadedQuestions = questionDao.getQuestions();
        assertEquals(QUESTIONS_COUNT, loadedQuestions.size());
    }

    @Test
    public void emptyFileTest() {
        when(i18nService.getMessageByCode("file.name")).thenReturn(NON_EXISTS_FILE);
        var ex = assertThrows(FileNotPresentException.class, questionDao::getQuestions);
        assertEquals(NON_EXISTS_FILE, ex.getMessage());
    }

    @Test
    public void wrongFormatFileTest() {
        when(i18nService.getMessageByCode("file.name")).thenReturn(WRONG_FORMAT_FILE);
        assertThrows(ParsingException.class, questionDao::getQuestions);
    }
}
