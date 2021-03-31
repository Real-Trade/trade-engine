package com.realtrade.tradeengine.services;

import com.realtrade.tradeengine.dto.ExchangeOrderDto;
import com.realtrade.tradeengine.models.Exchange;
import com.realtrade.tradeengine.models.MallonExchange;
import com.realtrade.tradeengine.models.Order;
import com.realtrade.tradeengine.models.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BestValueExchange {

        private List<Double> exchange1;
        private List<Double> exchange2;
        private Order currentClientOrder;
        private boolean requireSplit;

        public BestValueExchange() {}

        public BestValueExchange(List<ExchangeOrderDto> exchange1, List<ExchangeOrderDto> exchange2, Order order) {
                this.exchange1 = exchange1.stream().map(ExchangeOrderDto::getPrice).collect(Collectors.toList());
                this.exchange2 = exchange2.stream().map(ExchangeOrderDto::getPrice).collect(Collectors.toList());
                this.currentClientOrder = order;
        }

        public MallonExchange compareSellPrices() {
                if(exchange2.size() == 0) return MallonExchange.MALEX1;
                return (exchange1.get(0) < exchange2.get(0)) ? MallonExchange.MALEX1 : MallonExchange.MALEX2;
        }

        public MallonExchange compareBuyPrices() {
                if(exchange2.size() == 0) return MallonExchange.MALEX1;
                return (exchange1.get(0) > exchange2.get(0)) ? MallonExchange.MALEX1 : MallonExchange.MALEX2;
        }
}
