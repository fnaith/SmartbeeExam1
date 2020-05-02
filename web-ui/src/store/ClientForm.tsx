class ClientForm {
  companyId: number;
  name: string;
  email: string;
  phone: string;

  constructor() {
    this.companyId = -1;
    this.name = "";
    this.email = "";
    this.phone = "";
  }
}
  
export default ClientForm;
