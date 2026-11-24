const userForm = document.getElementById("userForm");

userForm.addEventListener("submit", async function (event) {
    event.preventDefault();

    const userData = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
    };

    try {
        const response = await fetch("http://localhost:8080/api/users", {
            method: "POST",

            headers: {
                "Content-Type": "application/json",
            },

            body: JSON.stringify(userData),
        });

        const responseText = await response.text();

        console.log("Status:", response.status);
        console.log("Response:", responseText);

        if (!response.ok) {
            throw new Error(`Server error ${response.status}: ${responseText}`);
        }

        const result = JSON.parse(responseText);

        document.getElementById("message").innerText =
            "User saved successfully! : " +result.name;

        console.log(result.name)

        userForm.reset();
    } catch (error) {
        console.error("Error:", error);

        document.getElementById("message").innerText = error.message;
    }
});