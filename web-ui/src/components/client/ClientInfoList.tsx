import React from 'react';

import global_data from '../../store/global_data';

import ClientInfo from './ClientInfo';

function ClientInfoList() {
  const clientForms = global_data.clientInfos.map((clientInfo: any, i: number) =>
    <ClientInfo index={i} key={`${clientInfo.companyId}-${clientInfo.name}-${clientInfo.address}-${clientInfo.createdBy}-${clientInfo.updatedAt}-${i}`}/>);

  return (
    <div>
      {clientForms}
    </div>
  );
}

export default ClientInfoList;
