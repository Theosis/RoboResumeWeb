use cv;

insert into person (name, email) values ("George Paley", "George@JDPaley.com");
set @person_id = last_insert_id();

insert into edu (ach, org, yr) values ("Counseling Psychology", "Holos", 2000);

insert into wrk (role, org, era) values ("CTO", "Genstar", "2008-2014");
set @wrk_id = last_insert_id();

insert into dty (duty) values ();

insert into skl () values ();
-- ----------------------------------------------------------------
insert into person (name, email) values ("Jill", "Jill@dom.com");
insert into person (name, email) values ("Joe", "Joe@dom.com");

