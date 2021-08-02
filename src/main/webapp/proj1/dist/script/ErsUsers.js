export default class ERS_USERS {
    /**
     * @param {number} ers_users_id
     * @param {string} ers_username
     * @param {string} ers_password
     * @param {string} user_first_name
     * @param {string} user_last_name
     * @param {string} user_email
     * @param {number} user_role_id
     * @param {object} contact
     * @param {number} id used to identify if record in SQL, 0 if not
     */


    constructor(ers_users_id, ers_username, ers_password, user_first_name, user_last_name, 
        user_email, user_role_id, city, street, state, zip, phone, id = 0){

            this.ers_users_id = ers_users_id;
            this.ers_username = ers_username;
            this.ers_password = ers_password;
            this.user_first_name = user_first_name.slice(0,1).toUpperCase() + user_first_name.slice(1);
            this.user_last_name = user_last_name.slice(0,1).toUpperCase() + user_last_name.slice(1);
            this.user_email = user_email;
            this.user_role_id = user_role_id;
            this.city = city;
            this.street = street;
            this.state = state;
            this.zip = zip;
            this.phone = phone;
            this.id = id
        }
        
    
}