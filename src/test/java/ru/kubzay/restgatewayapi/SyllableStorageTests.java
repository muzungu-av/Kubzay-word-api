package ru.kubzay.restgatewayapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ru.kubzay.restgatewayapi.storage.syllable.SyllableStorage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SyllableStorageTests implements ApplicationContextAware {

    private ApplicationContext context;

    /**
     * проверяем что класс - синглтон
     */
    @Test
    void syllableStorageSingletonLoads() {
        SyllableStorage storage1 = context.getBean(SyllableStorage.class);
        SyllableStorage storage2 = context.getBean(SyllableStorage.class);
        assertEquals(storage1, storage2);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
