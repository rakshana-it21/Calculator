let display = document.getElementById("display");

function append(value) {
  display.textContent += value;
}

function clearAll() {
  display.textContent = "";
}

function clearOne() {
  display.textContent = display.textContent.slice(0, -1);
}

function calculate() {
  try {
    let expression = display.textContent.trim();
    let operatorMatch = expression.match(/[\+\-\*\/%]/);

    if (!operatorMatch || operatorMatch.length !== 1) {
      display.textContent = "Invalid";
      return;
    }

    let operator = operatorMatch[0];
    let [num1, num2] = expression.split(operator);
    num1 = parseInt(num1.trim());
    num2 = parseInt(num2.trim());

    if (isNaN(num1) || isNaN(num2)) {
      display.textContent = "Invalid Numbers";
      return;
    }

    let result;
    switch (operator) {
      case '+': result = num1 + num2; break;
      case '-': result = num1 - num2; break;
      case '*': result = num1 * num2; break;
      case '/':
        if (num2 === 0) {
          display.textContent = "Divide by 0!";
          return;
        }
        result = Math.floor(num1 / num2);
        break;
      case '%': result = num1 % num2; break;
      default:
        display.textContent = "Invalid Op";
        return;
    }

    // Show result on frontend
    display.textContent = result;

    // Send to backend
    fetch(`http://localhost:8080/api/calculate/${num1}/${num2}/${result}`, {
      method: 'POST'
    })
    .then(res => res.text())
    .then(data => {
      console.log("Saved to backend:", data);
    })
    .catch(err => {
      console.error("Error sending to backend:", err);
    });

  } catch (e) {
    display.textContent = "Error";
  }
}
