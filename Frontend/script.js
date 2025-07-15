function updateScore() {
  // Simulate new score
  const score = Math.floor(Math.random() * 200) + "/4";
  const overs = (Math.random() * 20).toFixed(1);

  document.getElementById("score1").innerText = score;
  document.getElementById("overs1").innerText = overs;
  document.getElementById("status").innerText = "Team A is still batting";
}

// Auto-refresh every 30 seconds
setInterval(updateScore, 30000);
