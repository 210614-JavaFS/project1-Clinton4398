export default class ERS_REIMBURSEMENT {
    /**
     * @param {number} reimb_id;
     * @param {number} reimb_amount;
     * @param {string} reimb_submitted;
     * @param {string} reimb_resolved;
     * @param {string} reimb_author;
     * @param {string} reimb_resolver;
     * @param {number} reimb_status_id;
     * @param {number} reimb_type_id;
     */

    constructor(reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_author, reimb_resolver,
        reimb_status_id, reimb_type_id){
            this.reimb_id = reimb_id;
            this.reimb_amount = reimb_amount;
            this.reimb_submitted = reimb_submitted;
            this.reimb_resolved = reimb_resolved;
            this.reimb_authro = reimb_author;
            this.reimb_resolver = reimb_resolver;
            switch(reimb_status_id){
                case "APPROVED":
                    this.reimb_status_id = 1;
                    break;
                case "PENDING":
                    this.reimb_status_id = 2;
                    break;
                case "DENIDED":
                    this.reimb_status_id = 3;
                    break;
                }
            switch(reimb_type_id){
                case "MOVING":
                    this.reimb_type_id = 1;
                    break;
                case "PARKING":
                    this.reimb_type_id = 2;
                    break;
                case "COMMUTE":
                    this.reimb_type_id = 3;
                    break;
                case "BUSINESS":
                    this.reimb_type_id = 4;
                    break;
                case "OTHER":
                    this.reimb_type_id = 5;
                    break;
            }
        }
}

