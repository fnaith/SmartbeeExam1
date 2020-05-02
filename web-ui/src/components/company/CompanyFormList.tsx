import React from 'react';

import global_data from '../../store/global_data';

import CompanyForm from './CompanyForm';

function CompanyFormList() {
  const companyForms = global_data.companyForms.map((companyForm, i) => <CompanyForm index={i} key={`${companyForm.name}-${companyForm.address}-${i}`}/>);

  return (
    <div>
      {companyForms}
    </div>
  );
}

export default CompanyFormList;
