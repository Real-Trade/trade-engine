package com.realtrade.tradeengine.models;

import java.util.List;

public class MalExOne extends Exchange {
    private static MalExOne malExOne = null;

    private MalExOne() {
        super("Mallon Exchange One", MallonExchange.MALEX1,
                "https://exchange.matraining.com/",List.of("MSFT",
                    "NFLX", "GOOGL", "AAPL", "TSLA", "IBM", "ORCL", "AMZN"
                ) );
    }

    public static MalExOne getMalexOne() {
        if (malExOne == null)
            malExOne = new MalExOne();

        return malExOne;
    }

}
