-- begin insert NewDocKind for CreditApplication
CREATE OR REPLACE FUNCTION baseInsert()
RETURNS integer
AS $$
DECLARE
    cnt integer = 0;
BEGIN
    cnt = (select count(CATEGORY_ID) from DF_DOC_KIND where CATEGORY_ID = '32fbafe9-7cd2-d342-02a7-06fbded6306a');
    if (cnt = 0) then
        insert into SYS_CATEGORY (ID, NAME, ENTITY_TYPE, IS_DEFAULT, CREATE_TS, CREATED_BY, VERSION, DISCRIMINATOR)
        values ('32fbafe9-7cd2-d342-02a7-06fbded6306a', 'Новая заявка на кредит', 'credit$CreditApplication', false, now(), 'system', 1, 1);

        insert into DF_DOC_KIND (CATEGORY_ID, CREATE_TS, CREATED_BY, VERSION, DOC_TYPE_ID, NUMERATOR_ID,
                                 NUMERATOR_TYPE, CATEGORY_ATTRS_PLACE, TAB_NAME, PORTAL_PUBLISH_ALLOWED, DISABLE_ADD_PROCESS_ACTORS, CREATE_ONLY_BY_TEMPLATE, fields_xml)
        values ('32fbafe9-7cd2-d342-02a7-06fbded6306a', now(), 'system', 1, 'fb887395-5eb3-44e0-81d2-afa37e95ebf3', 'f3cb08b9-27a6-498c-8fdc-16511fa73099',
                1, 1, 'Доп. поля', false, false, false,
'<?xml version="1.0" encoding="UTF-8"?>
<fields>
  <field name="date" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="docCategory" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="owner" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="department" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="comment" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="finishDatePlan" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="resolution" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="number" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="organization" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="parentCard" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="theme" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="credit" inDocKind="true" required="TRUE" visible="true" signed="false" />
  <field name="individual" inDocKind="true" required="TRUE" visible="true" signed="false" />
</fields>
'
);
end if;
return 0;
END;
$$
LANGUAGE plpgsql;
^
select baseInsert();^
drop function if exists baseInsert();^
-- end insert NewDocKind for CreditApplication