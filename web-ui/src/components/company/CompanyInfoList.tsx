import React from 'react';

import global_data from '../../store/global_data';

import CompanyInfo from './CompanyInfo';

function CompanyInfoList() {
  const companyForms = global_data.companyInfos.map((companyInfo: any, i: number) =>
    <CompanyInfo index={i} key={`${companyInfo.name}-${companyInfo.address}-${companyInfo.createdBy}-${companyInfo.updatedAt}-${i}`}/>);

  return (
    <div>
      {companyForms}
    </div>
  );
}

export default CompanyInfoList;
