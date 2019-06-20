const auth = {
    accessToken: ''
}

const signIn = (username, password) =>
    fetch(`http://localhost:8080/users/signin?username=${username}&password=${password}`, {method: 'POST'})
        .then((data) => data.text())
        .then((res) => {
            console.log(res);
            if (JSON.parse(res)) {
                throw new Error("Error occurred");
            } else {
                console.log('hello');
                auth.accessToken = res;
            }
        });

export {
    auth,
    signIn
}