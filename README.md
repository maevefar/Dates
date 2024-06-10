# FarleyEtude1Date

## Name
dates 

## Compile and Run
install jdk 

javac dates.java for compiling 
java dates for running 

## Description
My project can be given a date input and outputs if it is valid. To make the day valid it must be written in numeric and can have a leading 0 if 1 digit but doesn't need to. The day must be a day that would exist in the given month in the given year. To make month valid, it can be written similar to day in its numeric format with or without a leading 0, or it can be written in shorthand containing the first 3 letters of the month in all upper, all lower, or just the first character upper. To make year valid, it must be written in its numeric with 2 or 4 digitis. The given date must fall within the years 1753-3000. 

## Test Cases
Valid:
4-6-92
04/06/1992
3 AUG 97
12-Sep-1955
01-05-1753

Incorrect day:
32/01/2001
29/02/2003
0/10/1999
222-04-1988
A 05 2000
Aa 05 2000
3333/01/2000
 /4/2001
001/09/1967
1000/09/1967
000001/09/1967
001 May 2045 
111/03/2000
/1/1/11

Incorrect month:
6/00/2001
6/0/2001
8/14/2006
12/144/2006
6/ /2000
8 -2 2005
10 jAn 2002
10 JaN 2002
10 jAN 2002
10 JAn 2002
10 jaN 2002 
29 fb 2002
30 fbb 2002
26 f 2002
14 ffeeebbb 2002
15 011 2004
15 0011 2004
15 110 2004
15 0001 2004
15 001 2004 
15 00000011 2004

Correct month:
5 Jan 2067
5 JAN 2067
5 jan 2067

Incorrect year:
01-05-1752
26/08/3000
17/03/3001

Incorect format: 
/-/-/-
/---
///
/ / / 
26/08-2001
26 08/1998
26/08-2001
1 /27/2000
1/ 27/ 2000
1/27/ 2000
1/ 27 /2000
1/1/11/
Hello
1 2 3 4 
1 1 hello

Leap years: 
29 02 2000
29 02 2001
