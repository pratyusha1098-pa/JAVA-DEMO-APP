function showAlert() {
    alert("Welcome to our website! Let's get started.");
}

function loadCSS(filename) {
    var link = document.createElement("link");
    link.rel = "stylesheet";
    link.type = "text/css";
    link.href = filename;
    document.getElementsByTagName("head")[0].appendChild(link);
}

// Call the function to load the CSS file
loadCSS('/styles.css');