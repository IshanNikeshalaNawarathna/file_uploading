async function upload() {
    const email = document.getElementById("email").value;
    const file = document.getElementById("file").files[0];

    const  data = new FormData();
    data.append("email", email);
    data.append("file", file);

    const response = await fetch(
            "Uploading",
            {
                method: "POST",
                body: data
            }

    );
    if (response.ok) {
        console.log("Success");
    } else {
        console.log("Success");
    }
}