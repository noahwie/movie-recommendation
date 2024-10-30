import React, { useState } from 'react';

function App() {
  const [movie, setMovie] = useState<string | null>(null);

  const getRecommendation = async () => {
    try{
      const response = await fetch('http://localhost:8080/api/movies/recommendation');
      const data = await response.json();
      setMovie(data.title);
    } catch (error) {
      console.error("Failed to fetch movie recommendation", error);
    }
  };

  return (
    <div className="App">
      <h1>Don't know what to watch?</h1>
      {movie ? (
        <p>You should watch: <strong>{movie}</strong></p>
      ): (
        <button onClick={getRecommendation}>Press me to get a recommendation</button>
      )}
    </div>
  );
}

export default App;
