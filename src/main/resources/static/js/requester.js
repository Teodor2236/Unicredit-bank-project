
const host = "http://localhost:8080/";

async function requester(method, url, data) {
    const options = {
        method,
        headers: {},
    };

    if (data !== undefined) {
        options.headers["Content-Type"] = "application/json";
        options.body = JSON.stringify(data);
    }

    try {
        const response = await fetch(host + url, options);

        let result;

        if(response.status === 404){
            return null;
        }
        if (response.status !== 204) {
            result = await response.json();
        }

        if (response.ok !== true) {
            throw result;
        }

        return result;
    } catch (error) {
        alert(error.message);
        throw error;
    }
}

export const get = requester.bind(null, "GET");
export const post = requester.bind(null, "POST");
export const put = requester.bind(null, "PUT");
export const del = requester.bind(null, "DELETE");
