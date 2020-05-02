import React from 'react';

import global_data from '../../store/global_data';

import ClientForm from './ClientForm';

function ClientFormList() {
  const clientForms = global_data.clientForms.map((clientForm, i) =>
    <ClientForm index={i} key={`${clientForm.companyId}-${clientForm.name}-${clientForm.email}-${clientForm.phone}-${i}`}/>);

  return (
    <div>
      {clientForms}
    </div>
  );
}

export default ClientFormList;
