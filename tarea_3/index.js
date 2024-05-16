let selectedCards = [];
let points = 0;

const cards = document.querySelectorAll(".card");
const scoreElement = document.querySelector(".score");
const resetButton = document.querySelector("button");

const handleCardClick = (event) => {
  const card = event.target;
  card.classList.remove("covered");
  selectedCards.push(card);

  if (selectedCards.length === 2) {
    if (selectedCards[0].dataset.card === selectedCards[1].dataset.card) {
      points++;
      updatePoints();
      selectedCards.forEach((card) => {
        card.removeEventListener("click", handleCardClick);
      });
      selectedCards = [];
    } else {
      setTimeout(() => {
        selectedCards.forEach((card) => {
          card.classList.add("covered");
        });
        selectedCards = [];
      }, 1000);
    }
  }
}

const updatePoints = () => {
  scoreElement.textContent = `Puntos: ${points}`;
}

const resetGame = () => {
  points = 0;
  updatePoints();
  cards.forEach((card) => {
    card.classList.add("covered");
    card.addEventListener("click", handleCardClick);
  });
}

resetButton.addEventListener("click", resetGame);

cards.forEach((card) => {
  card.addEventListener("click", handleCardClick);
});
