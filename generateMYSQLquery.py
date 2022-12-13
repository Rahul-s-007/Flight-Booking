"""
# Other imp queries
# insert new flight detail
insert into allFlightNum values("PK505","Dubai","Pune","2023-00-00 15:00:00",0);

# update num seats booked
int s = select sum(seatTaken) from PK505
UPDATE allFlightNum SET numBookedSeats = <(prev + new) or > WHERE flightnum = "PK505";

# Get available flights
SELECT flightnum from allFlightNum WHERE destTO = "Dubai" AND destFROM = "PUNE" AND DATE(flightDATE) >= "2021-08-01" AND numBookedSeat <= 34-<num of seats needed> ORDER BY flightDATE ASC;

select flightnum, TIME(flightDATE), TIME(arrivalDATE), price from allflightnum where destTO = "Pune" AND destFROM = "Dubai" AND DATE(flightDATE) = "2023-01-07" AND numAvailableSeats >= 5 ORDER BY price ASC;

#insert into EK507 values("x1",0,null);
#insert into EK507 values("x2",0,null);
#insert into EK507 values("x3",0,null);
#insert into EK507 values("y1",0,null);
#insert into EK507 values("y2",0,null);
#insert into EK507 values("y3",0,null);

"""

flightname = "EK002"

s ="""
create table EK507(seatName varchar(3), seatTaken int(2), bookedBy varchar(30));

insert into EK507 values("a1",0,null);
insert into EK507 values("a2",0,null);
insert into EK507 values("a3",0,null);
insert into EK507 values("a4",0,null);
insert into EK507 values("a5",0,null);
insert into EK507 values("a6",0,null);
insert into EK507 values("a7",0,null);

insert into EK507 values("b1",0,null);
insert into EK507 values("b2",0,null);
insert into EK507 values("b3",0,null);
insert into EK507 values("b4",0,null);
insert into EK507 values("b5",0,null);
insert into EK507 values("b6",0,null);
insert into EK507 values("b7",0,null);

insert into EK507 values("c1",0,null);
insert into EK507 values("c2",0,null);
insert into EK507 values("c3",0,null);
insert into EK507 values("c4",0,null);
insert into EK507 values("c5",0,null);
insert into EK507 values("c6",0,null);
insert into EK507 values("c7",0,null);

insert into EK507 values("d1",0,null);
insert into EK507 values("d2",0,null);
insert into EK507 values("d3",0,null);
insert into EK507 values("d4",0,null);
insert into EK507 values("d5",0,null);
insert into EK507 values("d6",0,null);
insert into EK507 values("d7",0,null);
""".replace("EK507",flightname)

print(s)