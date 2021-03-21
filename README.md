# trade-engine
Main path : "/order"

e.g. order
{
    "orderId": 1,
    "portfolioId": 1,
    "side": "BUY",
    "quantity": 2,
    "price": 5.0,
    "clientId": 1,
    "status": "OPEN",
    "product": "IBM"
}
                          METHOD            PATH
CREATE NEW ORDER          POST              /

UPDATE ORDER              PUT               /{orderId}

CANCEL ORDER              DELETE            /{orderId}
