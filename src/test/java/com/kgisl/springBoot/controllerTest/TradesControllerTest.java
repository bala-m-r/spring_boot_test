package com.kgisl.springBoot.controllerTest;

import com.kgisl.springBoot.Entity.Mytrades;
import com.kgisl.springBoot.controller.TradesController;
import com.kgisl.springBoot.service.TradesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TradesControllerTest {

    @Mock
    private TradesService tradesService;

    @InjectMocks
    private TradesController tradesController;

    @Test
    public void testGetAllTrades() throws Exception {
        Mytrades trade1 = new Mytrades(1, "ABC123", "ABC Corp", "BUY", 100, 50.5, "NYSE");
        Mytrades trade2 = new Mytrades(2, "XYZ456", "XYZ Inc", "SELL", 200, 75.0, "NASDAQ");

        List<Mytrades> expected = Arrays.asList(trade1, trade2);

        when(tradesService.getAllTrades()).thenReturn(expected);
        List<Mytrades> actual = tradesController.getAllTrades();
        assertNotNull(actual);
        assertEquals(expected, actual);

    }

    @Test
    public void testUpdateTrade() throws Exception {

        Mytrades updatedTrade = new Mytrades(1, "ABC123", "ABC Corp", "SELL", 150, 55.0, "NYSE");

        when(tradesService.updateTrade(anyInt(), any(Mytrades.class))).thenReturn(updatedTrade);

        Mytrades actual = tradesController.updateTrade(1, updatedTrade);
        assertNotNull(actual);
        assertEquals(updatedTrade, actual);
    }

    @Test
    public void testAddTradeCustom() throws Exception {
        
        doNothing().when(tradesService).addNewTrade(anyInt(), anyString(),
                anyString(), anyString(), anyInt(), anyDouble(), anyString());

        tradesController.addNewTrade(1, "ABC123", "ABC Corp", "BUY", 100, 50.5, "NYSE");

        verify(tradesService, times(1)).addNewTrade(1, "ABC123", "ABC Corp", "BUY", 100, 50.5, "NYSE");
    }

    @Test
    public void testDeleteTrade() {
        doNothing().when(tradesService).deleteTradeById(1);

        tradesController.deleteTrade(1);

        verify(tradesService, times(1)).deleteTradeById(1);
    }
}
