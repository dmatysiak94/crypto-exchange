CREATE TABLE IF NOT EXISTS top_currencies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50),
    symbol VARCHAR(5),
    market_cap_rank INTEGER,
    price_btc NUMERIC(12, 2),
    score INTEGER,
    request_by VARCHAR(10),
    timestamp TIMESTAMP
)