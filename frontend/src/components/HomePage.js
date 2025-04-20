import React from 'react';

const HomePage = () => {
  const headerStyle = {
    backgroundColor: '#004d99',
    color: 'white',
    padding: 0,
    marginTop: -50,
    marginBottom: 10
  };

  const titleStyle = {
    fontSize: 36,
    margin: 10,
    marginBottom: 10
  };

  const subtitleStyle = {
    fontSize: 18,
    margin: 10,
    marginBottom: 10
  };

  const mainStyle = {
    padding: 20,
    marginBottom: 10
  };

  const sectionTitleStyle = {
    color: '#004d99',
    marginBottom: 10
  };

  const paragraphStyle = {
    color: '#333',
    fontSize: 16,
    marginBottom: 10
  };

  const footerStyle = {
    backgroundColor: '#004d99',
    color: 'white',
    padding: 20,
    textAlign: 'center'
  };

  const footerText = {
    fontSize: 14,
    margin: 10
  };

  return (
    <div>
      <header style={headerStyle}>
        <h1 style={titleStyle}>Faculté des Arts et des Sciences Créatives</h1>
        <p style={subtitleStyle}>Une faculté où l'imagination prend vie</p>
      </header>

      <main style={mainStyle}>
        <h2 style={sectionTitleStyle}>Présentation de la faculté</h2>
        <p style={paragraphStyle}>La Faculté des Arts et des Sciences Créatives est un lieu d'apprentissage et d'exploration pour les esprits créatifs. Nous encourageons nos étudiants à repousser les limites de l'innovation et à développer leur pensée critique. Nos programmes uniques intègrent les arts, les sciences et la technologie pour former des individus polyvalents et visionnaires.</p>

        <h2 style={sectionTitleStyle}>Mot du doyen</h2>
        <p style={paragraphStyle}>Chers étudiants, bienvenue à la Faculté des Arts et des Sciences Créatives ! Ici, vous trouverez un environnement dynamique où vos idées prennent vie. Notre corps professoral dévoué vous guidera dans votre parcours d'apprentissage, vous encourageant à repousser les frontières de la créativité et de l'innovation. Rejoignez-nous pour façonner un avenir plein de possibilités infinies.</p>

        <h2 style={sectionTitleStyle}>Programmes offerts</h2>
        <ul style={paragraphStyle}>
          <li>Design et Communication Visuelle</li>
          <li>Informatique Créative</li>
          <li>Arts Numériques</li>
          <li>Sciences de l'Imagination</li>
          <li>Entrepreneuriat Créatif</li>
        </ul>

        <h2 style={sectionTitleStyle}>Vie étudiante</h2>
        <p style={paragraphStyle}>En dehors des salles de classe, notre faculté offre une variété d'activités et de clubs pour nourrir votre esprit créatif. Rejoignez notre chorale, notre troupe de théâtre ou notre club de photographie, et faites des rencontres inoubliables avec des personnes partageant les mêmes idées.</p>
      </main>

      <footer style={footerStyle}>
        <p style={footerText}>Faculté des Arts et des Sciences Créatives &copy; 2023. Tous droits réservés.</p>
      </footer>
    </div>
  );
};

export default HomePage;
