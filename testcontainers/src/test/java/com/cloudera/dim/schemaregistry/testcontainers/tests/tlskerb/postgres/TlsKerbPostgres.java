/**
 * Copyright 2016-2023 Cloudera, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.cloudera.dim.schemaregistry.testcontainers.tests.tlskerb.postgres;

import com.cloudera.dim.schemaregistry.testcontainers.env.db.DbType;
import com.cloudera.dim.schemaregistry.testcontainers.env.testsetup.TestSetup;
import com.cloudera.dim.schemaregistry.testcontainers.env.testsetup.parts.DbSetup;
import com.cloudera.dim.schemaregistry.testcontainers.env.testsetup.parts.KerberosSetup;
import com.cloudera.dim.schemaregistry.testcontainers.env.testsetup.parts.TlsSetup;

public class TlsKerbPostgres {

    private TlsKerbPostgres() {

    }

    public static TestSetup getTestSetup(String tempFolderPath) {
        DbSetup dbSetup = DbSetup.builder()
                .usedDbType(DbType.POSTGRES)
                .build();

        TlsSetup tlsSetup = TlsSetup.builder()
                .clientAuthRequired(false)
                .build();

        KerberosSetup kerberosSetup = KerberosSetup.builder()
                .build();

        TestSetup testSetup = TestSetup.builder()
                .dbSetup(dbSetup)
                .tlsSetup(tlsSetup)
                .kerberosSetup(kerberosSetup)
                .tempFolderPath(tempFolderPath)
                .build();

        return testSetup;
    }
}