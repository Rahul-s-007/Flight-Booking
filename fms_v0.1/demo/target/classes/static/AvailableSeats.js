// list of occupied seats
const occupiedSeats = ['A1','B1','C3','C4','B6']

// maximum number of seats that can be selected
const maxSeats = 5;

// counter for the number of selected seats
let selectedSeats = 0;

var selstring = "";

// var bookedstring = document.getElementById('bookedstring').value;
// console.log(bookedstring);
// get the seat map container
const seatMap = document.querySelector('.seat-map');

// create the seats
for (let row = 0; row < 7; row++) 
{
  for (let col = 0; col < 4; col++) 
  {
    // create a new div element for the seat
    const seat = document.createElement('div');
    // set the seat's class to 'seat'
    seat.classList.add('seat');
    // set the seat's id to the row and column (e.g. 'A1', 'B3')
    seat.id = String.fromCharCode(65 + col) + (row + 1);

    // if the seat is occupied, add the 'occupied' class
    if (occupiedSeats.includes(seat.id)) 
    {
      seat.classList.add('occupied');
    }

    // add a click event listener to the seat
    seat.addEventListener('click', () => 
    {
      // if the seat is occupied, do nothing
      if (seat.classList.contains('occupied')) 
      {
        return;
      }

      // if the maximum number of seats has been reached, do nothing
      if (selectedSeats >= maxSeats) 
      {
        return;
      }
      // if the seat is not occupied and not already selected,
      // add the 'selected' class and increment the selected seats counter
      if (!seat.classList.contains('selected')) 
      {
        seat.classList.add('selected');
        console.log('Seat clicked:', seat.id);
        const seat_no = document.getElementById("seat_no")
        seat_no.innerHTML += seat.id + " ";
        selstring+=seat.id+" ";
        document.getElementById("selectedstring").value = selstring;
        selectedSeats++;
      } 
      else
      {
        
        // if the seat is not occupied and is already selected,
        // remove the 'selected' class and decrement the selected seats counter

        const seats = document.querySelectorAll('.seat');
        // remove the 'selected' class from each seat
        seats.forEach(seat => seat.classList.remove('selected'));
      
        seat_no.innerHTML = "Seat No:";
        selectedSeats = 0;
        // seat.classList.remove('selected');
        // seat_no.innerHTML = "Seat No:";
        // seat_no.innerHTML = seat.id + " " + seat_no.innerHTML;
        selectedSeats--;
      }
    });
    // add the seat to the seat map
    seatMap.appendChild(seat);
  }
}
// create the reselect button
const reselectButton = document.createElement('button');
// set the text on the button
reselectButton.innerText = 'Reselect Seats';
reselectButton.type = "button";
// add a click event listener to the button
reselectButton.addEventListener('click', () => 
{
  // get all the seats
  const seats = document.querySelectorAll('.seat');
  // remove the 'selected' class from each seat
  seats.forEach(seat => seat.classList.remove('selected'));
  selstring = "";

  seat_no.innerHTML = "Seat No:";
  // reset the selected seats counter
  selectedSeats = 0;
});

// add the reselect button to the page
var buttons = document.getElementById('buttons');
buttons.appendChild(reselectButton);
