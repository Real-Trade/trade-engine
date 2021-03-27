package com.realtrade.tradeengine.models;

import java.util.List;

public class MalExTwo extends Exchange{
    private static MalExTwo malExTwo;

    private MalExTwo() {
        super("Mallon Exchange Two", MallonExchange.MALEX2,
                "http://exchange2.matraining.com/", List.of("MSFT",
                        "NFLX", "GOOGL", "AAPL", "TSLA", "IBM", "ORCL", "AMZN"
                ) );
    }

    public static MalExTwo getMalExTwo() {
        if (malExTwo == null)
            malExTwo = new MalExTwo();

        return malExTwo;
    }
}
