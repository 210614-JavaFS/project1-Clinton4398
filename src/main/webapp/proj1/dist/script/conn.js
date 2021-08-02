const Conn = {
    get: async (url, params={}) => (await fetch(url. params).json()),
    send: async (url, params={})=> (await fetch(url, params.json())),
    }
    
    export default Connection;
