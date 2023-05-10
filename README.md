# Quatro

Projekt na zajęcia: Korporacyjna Java

Program do rozwiązywania zadań geometrycznych 2D

Początkowo interfejs tekstowy z poziomu konsoli, docelowo będzie rozszerzany o możliwości przetwarzania plików i serwisy
REST'owe, możliwe jeszcze inne wejścia

## Pracownia 1

### Wymagania ogólne

* Program ma umożliwić rozwiązywanie podstawowych zadań geometrycznych dla kwadratu i koła
* Ma wyświetlić pełne informacje o danej figurze, na podstawie zadanego wejścia
* Obsługa błędów

#### Pracownia: Kwadrat

Charakterystyka figury

* Długość boku
* Długość przekątnej
* Pole powierzchni

Możliwe wejście:

* Długość boku
* Długość przekątnej
* Pole powierzchni

#### Pracownia: Koło

Charakterystyka figury:

* Promień
* Średnica
* Obwód
* Pole powierzchni

Możliwe wejście

* Promień
* Średnica
* Obwód
* Pole powierzchni

## Pracownia 2

### Wymagania ogólne

* Program ma umożliwić rozwiązywanie podstawowych zadań geometrycznych dla prostokąta i rombu
* Ma wyświetlić pełne informacje o danej figurze, na podstawie zadanego wejścia

#### Pracownia: Prostokąt

Charakterystyka figury:

* Długości krótszego i dłuższego boku
* Długość przekątnej
* Pole powierzchni

Możliwe wejście: (dowolna dwójka):

* Długości boków
* Długość przekątnej
* Pole powierzchni

#### Pracownia: Romb

Charakterystyka figury:

* Długość boku
* Długości krótszej i dłuższej przekątnej
* Pole powierzchni

Możliwe wejście: (dowolna dwójka):

* Długość boku
* Długości przekątnych
* Pole powierzchni

## Pracowania 3

### Wymagania ogólne

* Program ma umożliwić rozwiązywanie podstawowych zadań geometrycznych dla trójkąta równobocznego
* Ma wyświetlić pełne informacje o danej figurze, na podstawie zadanego wejścia
* Program ma umożliwić wyświetlenie informacji o wszystkich wprowadzonych figurach posortowanych wg pola powierzchni
  rosnąco

#### Pracownia: Trójkąt równoboczny

Charakterystyka figury

* Długość boku
* Pole powierzchni
* Wysokość

Możliwe wejście:

* Długość boku
* Pole powierzchni
* Wysokość

## Pracownia 4

### Wymagania ogólne

* Program ma umożliwić rozwiązywanie podstawowych zadań geometrycznych dla trójkąta równoramiennego
* Program ma wyświetlać numerową listę wprowadzonych figur z możliwością zmiany rodzaju sortowania na maleją wg pola
  powierzchni oraz wg obwodu rosnąco / malejąco
* Użytkownik może wybrać figurę z listy i wykonać na niej akcję: zwróć mi koło opisane na tej figurze (Na rombie się da
  opisać koła... chyba, że jest kwadratem)

#### Pracownia: Trójkąt równoramienny

Charakterystyka figury

* Długość boku
* Długość podstawy
* Pole powierzchni
* Wysokość (od podstawy)

Możliwe wejście: (dowolna dwójka)

* Długość boku
* Długość podstawy
* Pole powierzchni
* Wysokość (od podstawy)

## Pracownia 5

### Wymagania ogólne

Program ma umożliwić rozwiązywanie podstawowych zadań geometrycznych dla trójkąta prostokątnego
* Program ma przechowywać informację kiedy dana figura została utworzona i zapewnić dodatkowo sortowanie wyników po dacie (rosnąco / malejąco)
* Użytkownik może wybrać figurę z listy i wykonać na niej akcję: podwojenie
* Zwraca figurę tego samego typu z 2 razy większym polem powierzchni zachowując proporcje

#### Trójkąt prostokątny
* Charakterystyka figury:
* Długość przyprostokątnej 1
* Długość przyprostokątnej 2
* Długość przeciwprostokątnej
* Pole powierzchni

Możliwe wejście: (dowolna dwójka)

* Długość przyprostokątnej 1
* Długość przyprostokątnej 2
* Długość przeciwprostokątnej
* Pole powierzchni

## Pracownia 6

### Wymagania ogólne

Program ma umożliwić rozwiązywanie podstawowych zadań geometrycznych dla elipsy
* Program ma umożliwiać opcję sortowania dwupoziomowego wprowadzonych figur:
  * Drugi poziom tak jak do tej pory
  * Pierwszy poziom rosnąco i malejąco po liczbie wierzchołków
* Program ma umożliwiać konfigurację zaokrągleń
  * Domyślna wartość: 2 miejsca po przecinku
  * Zaokrąglenia nie zmieniają wartości właściwości figur (ani nie wpływają na wartości wprowadzane / wyliczane), wpływają tylko i wyłącznie na sposób ich wyświetlania
* Użytkownik może wybrać figurę z listy i wykonać na niej akcję: usuń z listy

#### Elipsa
Charakterystyka figury:
* Półoś wielka
* Półoś mała
* Pole powierzchni

Możliwe wejście: (dowolna dwójka)
* Półoś wielka
* Półoś mała
* Pole powierzchni

Obwód elipsy liczymy pierwszym przybliżeniem całki eliptycznej.


## Pracownia 7

### Wymagania ogólne
Program ma umożliwić rozwiązywanie podstawowych zadań geometrycznych dla
trapezu równoramiennego
* Program ma umożliwić asynchroniczne zapisanie wszystkich przechowywanych figur do pliku
* Opis każdej figury w jednej linii !
* Wycofujemy się z dwupoziomowego sortowania figur
* Sortowanie po liczbie wierzchołków dodajemy jako kolejną możliwość sposobu sortowania

#### Trapez równoramienny
Charakterystyka figury:
* Podstawa 1
* Podstawa 2
* Ramię
* Wysokość
* Pole powierzchni
Możliwe wejście: (dowolna trójka)
* Podstawa 1
* Podstawa 2
* Ramię
* Wysokość
* Pole powierzchni
2 z 10 przypadków: (podstawa 1-2, ramię, pole powierzchni) nie muszą być rozpatrywane