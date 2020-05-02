import CompanyForm from './CompanyForm';
import ClientForm from './ClientForm';

function logRequestError(url: string, error: any) {
  const msg: string = `{url=${url},error=${error}}`;
  console.error(msg);
  alert(msg);
}

class AppStore {
  private static readonly DEFAULT_TIMEZONE: string = 'Asia/Taipei';
  private static readonly DEFAULT_LOCALE: string = 'en-US';

  private readonly _apiPath = `${window.location.protocol}//${window.location.hostname}:8080`;

  private _initted: boolean;
  private _updateControlPanel: any;
  private _companyForms: CompanyForm[];
  private _companyInfos: any;
  private _clientForms: ClientForm[];
  private _clientInfos: any;

  constructor() {
    this._initted = false;
    this._companyForms = [];
    this._companyInfos = [];
    this._clientForms = [];
    this._clientInfos = [];
  }

  get updateControlPanel(): any {
    return this._updateControlPanel;
  }

  set updateControlPanel(updateControlPanel: any) {
    this._updateControlPanel = updateControlPanel;
  }

  get companyForms(): CompanyForm[] {
    return this._companyForms;
  }

  get companyInfos(): any {
    return this._companyInfos;
  }

  get clientForms(): ClientForm[] {
    return this._clientForms;
  }

  get clientInfos(): any {
    return this._clientInfos;
  }

  formatTime(timestamp: number): string {
    const date: Date = new Date(timestamp);
    const options: any = { timeZone: AppStore.DEFAULT_TIMEZONE, hour12: false };
    const formattedDateTime: string = date.toLocaleString(AppStore.DEFAULT_LOCALE, options);
    return formattedDateTime;
  }

  init() {
    if (this._initted) {
      return;
    }
    this.readCompanies(console.log);
    this.readClients(console.log);
    this.updateControlPanel();
    this._initted = true;
  }

  addCompanyForm() {
    var companyForm: CompanyForm = new CompanyForm();
    companyForm.name = 'Company Name';
    companyForm.address = 'Company Address';
    this.companyForms.push(companyForm);
  }

  removeCompanyForm(index: number) {
    this.companyForms.splice(index, 1);
  }

  createCompanies(callback: any) {
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(this.companyForms.map(companyForm => {
        return {id: -1, name: companyForm.name, address: companyForm.address,
          createdBy: "", createdAt: 0, updatedBy: '', updatedAt: 0};
      }))
    };
    const url = `${this._apiPath}/company`;
    fetch(url, requestOptions)
      .then(response => { if (200 != response.status) { throw response.status; } return response.json(); })
      .then(json => {
        this._companyForms = [];
        console.log(json);
        callback(json);
      })
      .catch(error => logRequestError(url, error));
  }

  readCompanies(callback: any) {
    const appStore: AppStore = this;
    const requestOptions = {
      method: 'GET',
      headers: { 'Content-Type': 'application/json' }
    };
    const url = `${this._apiPath}/company`;
    fetch(url, requestOptions)
      .then(response => { if (200 != response.status) { throw response.status; } return response.json(); })
      .then(json => {
        appStore._companyInfos = json;
        console.log(json);
        callback(json);
      })
      .catch(error => logRequestError(url, error));
  }

  saveCompanyInfo(index: number, callback: any) {
    const appStore: AppStore = this;
    const requestOptions = {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(this.companyInfos[index])
    };
    const url = `${this._apiPath}/company/${this.companyInfos[index].id}`;
    fetch(url, requestOptions)
      .then(response => { if (200 != response.status) { throw response.status; } return response.json(); })
      .then(json => {
        appStore.companyInfos[index] = json;
        console.log(json);
        callback(json);
      })
      .catch(error => logRequestError(url, error));
  }

  removeCompanyInfo(index: number, callback: any) {
    const appStore: AppStore = this;
    const requestOptions = {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' }
    };
    const url = `${this._apiPath}/company/${this.companyInfos[index].id}`;
    fetch(url, requestOptions)
      .then(response => {
        appStore._companyInfos.splice(index, 1);
        callback();
      })
      .catch(error => logRequestError(url, error));
  }

  getCompanyName(companyId: number) {
    for (let i = 0; i < this.companyInfos.length; ++i) {
      const companyInfo: any = this.companyInfos[i];
      if (companyId == companyInfo.id) {
        return `(${companyInfo.id})${companyInfo.name}`;
      }
    }
    return 'Unknown Company';
  }

  addClientForm() {
    var clientForm: ClientForm = new ClientForm();
    clientForm.name = 'Client Name';
    clientForm.email = 'Company Email';
    clientForm.phone = 'Company Phone';
    this.clientForms.push(clientForm);
  }

  removeClientForm(index: number) {
    this.clientForms.splice(index, 1);
  }

  createClients(callback: any) {
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(this.clientForms.map(clientForm => {
        return {id: -1, companyId: clientForm.companyId,  name: clientForm.name,
          email: clientForm.email, phone: clientForm.phone,
          createdBy: "", createdAt: 0, updatedBy: '', updatedAt: 0};
      }))
    };
    const url = `${this._apiPath}/client`;
    fetch(url, requestOptions)
      .then(response => { if (200 != response.status) { throw response.status; } return response.json(); })
      .then(json => {
        this._clientForms = [];
        console.log(json);
        callback(json);
      })
      .catch(error => logRequestError(url, error));
  }

  readClients(callback: any) {
    const appStore: AppStore = this;
    const requestOptions = {
      method: 'GET',
      headers: { 'Content-Type': 'application/json' }
    };
    const url = `${this._apiPath}/client`;
    fetch(url, requestOptions)
      .then(response => { if (200 != response.status) { throw response.status; } return response.json(); })
      .then(json => {
        appStore._clientInfos = json;
        console.log(json);
        callback(json);
      })
      .catch(error => logRequestError(url, error));
  }

  saveClientInfo(index: number, callback: any) {
    const appStore: AppStore = this;
    const requestOptions = {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(this.clientInfos[index])
    };
    const url = `${this._apiPath}/client/${this.clientInfos[index].id}`;
    fetch(url, requestOptions)
      .then(response => { if (200 != response.status) { throw response.status; } return response.json(); })
      .then(json => {
        appStore.clientInfos[index] = json;
        console.log(json);
        callback(json);
      })
      .catch(error => logRequestError(url, error));
  }

  removeClientInfo(index: number, callback: any) {
    const appStore: AppStore = this;
    const requestOptions = {
      method: 'DELETE',
      headers: { 'Content-Type': 'application/json' }
    };
    const url = `${this._apiPath}/client/${this.clientInfos[index].id}`;
    fetch(url, requestOptions)
      .then(response => {
        appStore._clientInfos.splice(index, 1);
        callback();
      })
      .catch(error => logRequestError(url, error));
  }

  logout() {
    const requestOptions = {
      method: 'GET',
      headers: { 'Content-Type': 'application/json' }
    };
    const url = `${this._apiPath}/login?logout`;
    window.location.href = url;
  }
}

export default AppStore;
