CREATE TABLE IF NOT EXISTS public.payment(
    id uuid NOT NULL PRIMARY KEY,
    "value" numeric(12,2) NOT NULL,
    status TEXT NOT NULL,
    order_id int8 NOT NULL,
    payment_method_id int8 NOT NULL,
    card_name TEXT NOT NULL,
    card_number TEXT NOT NULL,
    card_expiration TEXT NOT NULL,
    card_code TEXT NOT NULL
);