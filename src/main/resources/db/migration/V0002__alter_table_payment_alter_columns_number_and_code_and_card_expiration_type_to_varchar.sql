ALTER TABLE public.payment ALTER COLUMN card_number TYPE varchar(16);

ALTER TABLE public.payment ALTER COLUMN card_code TYPE varchar(3);

ALTER TABLE public.payment ALTER COLUMN card_expiration TYPE varchar(7);